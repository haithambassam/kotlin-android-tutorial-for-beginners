class FileDownloader(private val file: String) : Downloader {
    override fun download() {
        println("$file Downloaded")
    }
}

class FilePlayer(private val file: String) : Player {
    override fun play() {
        println("$file Playing")
    }
}


// This is delegation, Kotlin helps you to achieve this without writing the boilerplate code that exists in the second example.
class MediaFile(
        private val downloader: Downloader,
        private val player: Player
) : Downloader by downloader, Player by player



// This is delegation, this contains boilderplate code, both code works.
class MediaFile(
        private val downloader: Downloader,
        private val player: Player
) : Downloader , Player{
    
    override fun download() {
        downloader.downlaod()
    }
    
    override fun play() {
        player.play()
    }
}


fun main() {
    val file: String = "File1.mkv"
    val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file))
    mediaFile.download()
    mediaFile.play()
}
