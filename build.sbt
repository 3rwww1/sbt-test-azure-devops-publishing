publishTo in ThisBuild := Some("vsts" at "https://pkgs.dev.azure.com/aironek/sbt-test/_packaging/sbt-test/maven/v1")

organization in ThisBuild := "org.test"
scalaVersion in ThisBuild := "2.11.11"
dynverVTagPrefix in ThisBuild := false
version in ThisBuild ~= (_.replace('+', '-').split("-").slice(0, 4).mkString("-") + (sys.env.get("BUILD_BUILDID").map("-" + _).getOrElse("")))

name := "publishing"

credentials in ThisBuild += {
  Credentials(
    realm = null,
  	host = "pkgs.dev.azure.com",
    userName = "aironek",
    passwd = sys.env.get("AZURE_PAT").get
  )
}

publishMavenStyle := true

resolvers := List(
  "Azure Artifacts" at "https://pkgs.dev.azure.com/aironek/sbt-test/_packaging/sbt-test/maven/v1"
)

ThisBuild / useCoursier := false
