//
// Copyright (c) 2014 Alexey Aksenov ezh@ezh.msk.ru
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import sbt.application._
import sbt.aspectj.nested._
import sbt.osgi.manager._

Application ++ AspectJNested ++ OSGiManager

inConfig(OSGiConf)({
  import OSGiKey._
  Seq(
    osgiBndBundleActivator := "org.digimead.tabuddy.desktop.core.ui.inspector.Activator",
    osgiBndBundleCopyright := "Copyright © 2014 Alexey B. Aksenov/Ezh. All rights reserved.",
    osgiBndBundleLicense := "http://www.gnu.org/licenses/agpl.html;description=GNU Affero General Public License",
    osgiBndBundleSymbolicName := "org.digimead.tabuddy.desktop.core.ui.inspector",
    osgiBndExportPackage := List("org.digimead.tabuddy.desktop.core.ui.inspector.*"),
    osgiBndImportPackage := List("!org.aspectj.*", "*"),
    osgiBndRequireCapability := """osgi.ee;filter:="(&(osgi.ee=JavaSE)(version>=1.7))"""")
})

name := "digi-tabuddy-desktop-core-ui-inspector"

description := "TA Buddy: Desktop application UI inspector."

version <<= (baseDirectory) { (b) => scala.io.Source.fromFile(b / "version").mkString.trim }

crossScalaVersions := Seq("2.11.2")

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked", "-Xcheckinit", "-feature")

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

resolvers += "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"

resolvers += "digimead-maven" at "http://commondatastorage.googleapis.com/maven.repository.digimead.org/"

lazy val extConfiguration = config("external").hide

ivyConfigurations += extConfiguration

lazy val core = RootProject(uri("git://github.com/digimead/digi-TABuddy-desktop.git"))

val main = Project(id = "application", base = file(".")).dependsOn(core % extConfiguration)

// Add base dependencies

libraryDependencies ++= (libraryDependencies in core).value

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"

managedClasspath in Compile <++= (managedClasspath in Compile in core)

managedClasspath in Runtime <++= (managedClasspath in Runtime in core)

managedClasspath in Test <++= (managedClasspath in Test in core)

ivyConfigurations <<= (ivyConfigurations) {configs => configs.map(c => if (c.name == "test") {c hide} else c) }

//logLevel := Level.Debug
