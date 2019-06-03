object zad25 extends App{

    val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
    strefy
        .filter(_.startsWith("Europe"))
        .map(_.stripPrefix("Europe/"))
}