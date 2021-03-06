import org.scalajs.sbtplugin.cross.CrossProject
import sbt.{ClasspathDependency, LocalProject}

object LocalCrossProject {

  implicit class LocalCrossProjectOps(crossProject: CrossProject) {

    def dependsOnLocalCrossProjects(names: String*): CrossProject =
      crossProject
        .jsConfigure(_.dependsOn(names.map(name => LocalProject(s"${name}JS"): ClasspathDependency): _*))
        .jvmConfigure(_.dependsOn(names.map(name => LocalProject(s"${name}JVM"): ClasspathDependency): _*))

  }

}
