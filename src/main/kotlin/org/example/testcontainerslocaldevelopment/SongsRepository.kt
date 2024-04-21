import org.example.testcontainerslocaldevelopment.Song
import org.springframework.jdbc.core.JdbcTemplate

class SongsRepository(private val jdbcTemplate: JdbcTemplate) {
    fun create(song: Song) {
        jdbcTemplate.update("INSERT INTO songs (name, artist) VALUES (?, ?)", song.name, song.artist)
    }

    fun list(): List<Song> {
        return jdbcTemplate.query("SELECT name, artist FROM songs") { rs, _ ->
            Song(rs.getString("name"), rs.getString("artist"))
        }
    }
}