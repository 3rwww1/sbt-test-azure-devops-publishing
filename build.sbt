publishTo in ThisBuild := Some("vsts" at "https://pkgs.dev.azure.com/aironek/sbt-test/_packaging/sbt-test/maven/v1")

organization in ThisBuild := "org.test"
scalaVersion in ThisBuild := "2.11.11"
version in ThisBuild := "1.0.0"

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
