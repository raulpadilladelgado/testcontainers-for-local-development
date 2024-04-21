import org.example.testcontainerslocaldevelopment.Song
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.shell.command.annotation.Command
import org.springframework.stereotype.Component

@Command(group = "Songs")
@Component
class SongsController(jdbcTemplate: JdbcTemplate) {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private var songsRepository: SongsRepository = SongsRepository(jdbcTemplate)

    private var counter = 0

    @Command(command = ["create"], description = "Create a song")
    fun createSong() {
        songsRepository.create(Song("org.example.testcontainerslocaldevelopment.Song $counter", "Artist $counter"))
        counter++
    }

    @Command(command = ["list"], description = "List all songs")
    fun listSongs() {
        songsRepository.list().forEach { println(it) }
    }
}

