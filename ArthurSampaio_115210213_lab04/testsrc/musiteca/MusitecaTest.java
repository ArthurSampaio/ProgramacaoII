package musiteca;
import playlist.Playlist;

import static org.junit.Assert.*;

import album.Album;
import musica.Musica;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MusitecaTest {

	private Musiteca musitecaTest;
	private Album theWall;
	private Album darkSide;
	private Album turnBlue;
	private Album albumTeste;
	private Album albumTeste2;
	private Album albumTeste3;
	private Playlist noCarro;
	private Playlist academia;
	private Playlist triste;
	private Playlist muitoTriste;
	private Musica anotherBrick;
	

	@Before
	public void setUp() {
		try {
			musitecaTest = new Musiteca();
			theWall = new Album("Pink Floyd", "The Wall", 1982);
			darkSide = new Album("Pink Floyd", "The Dark Side of The Moon",
					1973);
			turnBlue = new Album("The Black Keys", "Turn Blue", 2011, true);
			albumTeste = new Album("Eu", "Album Teste", 1901, true);
			albumTeste2 = new Album("The Black Keys", "Turn Blue", 2011, true);
			albumTeste3 = new Album("Eu", "The Dark Side of The Moon", 1973);
			noCarro = new Playlist("No Carro");
			academia = new Playlist("Academia");
			triste = new Playlist("Triste");
			muitoTriste = new Playlist("Muito Triste");
			anotherBrick = new Musica("Another Brick", 6, "Progressivo");

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro.");
		}
	}

	@Test
	public void testAlbuns() {
		try {

			assertTrue(musitecaTest.addAlbum(theWall));
			assertTrue(musitecaTest.addAlbum(darkSide));
			assertTrue(musitecaTest.containsAlbum(theWall));
			assertTrue(musitecaTest.removeAlbum("The Wall"));
			assertFalse(musitecaTest.containsAlbum(theWall));
			assertTrue(musitecaTest.addAlbum(theWall));
			assertTrue(musitecaTest.addMusicaToAlbum("The Wall",
					"Another Brick in The Wall", 6, "Progressive"));
			assertTrue(musitecaTest.removeMusicaFromAlbum("The Wall",
					"Another Brick in The Wall"));

			assertEquals(darkSide,
					musitecaTest.getAlbum("The Dark Side of The Moon"));

			assertTrue(musitecaTest.addAlbum(turnBlue));
			musitecaTest.favoriteAlbum("Turn Blue");
			musitecaTest.favoriteAlbum("The Dark Side of The Moon");

			List<Album> teste = new LinkedList<Album>();
			teste.add(darkSide);
			teste.add(turnBlue);
			assertEquals(teste, musitecaTest.getAlbunsFavoritos());
			teste.remove(darkSide);
			musitecaTest.unfavoriteAlbum("The Dark Side of The Moon");
			assertEquals(teste, musitecaTest.getAlbunsFavoritos());

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro.");
		}
	}

	@Test
	public void testPlaylists() {
		try {
			assertTrue(musitecaTest.addAlbum(theWall));
			assertTrue(theWall.addMusica("Another Brick", 6, "Progressivo"));
			assertTrue(theWall.addMusica("Brick by Brick", 4, "Progressivo"));
			assertTrue(musitecaTest.addPlaylist(noCarro));
			assertTrue(musitecaTest.addPlaylist(triste));
			assertTrue(musitecaTest
					.addMusicaToPlaylist("De Boa", "The Wall", 1));
			assertEquals(anotherBrick,
					musitecaTest.getMusicaFromPlaylists("Another Brick"));
			assertTrue(musitecaTest
					.addMusicaToPlaylist("De Boa", "The Wall", 2));

			assertNotEquals(null,
					musitecaTest.getMusicaFromPlaylists("Brick by Brick"));

			assertTrue(musitecaTest.containsPlaylist(triste));
			assertTrue(musitecaTest.removePlaylist("No Carro"));
			assertFalse(musitecaTest.containsPlaylist(noCarro));

			assertTrue(musitecaTest.removeMusicaFromPlaylist("De Boa",
					"Another Brick"));
			assertEquals(null,
					musitecaTest.getMusicaFromPlaylists("Another Brick"));

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro.");
		}
	}

	@Test
	public void testInvalidosAlbuns() {
		try {
			musitecaTest.addAlbum(null);
			fail();

		} catch (Exception e) {
			assertEquals("Album nao pode ser nulo.", e.getMessage());
		}
		try {
			musitecaTest.addAlbum("Eu", "Meu Album", 1901);
			musitecaTest.favoriteAlbum("");
			fail();

		} catch (Exception e) {
			assertEquals("Titulo do album nÃ£o pode ser nulo ou vazio.",
					e.getMessage());
		}
		try {
			musitecaTest.addAlbum(darkSide);
			musitecaTest.removeAlbum("    ");
			fail();

		} catch (Exception e) {
			assertEquals("Titulo do album nÃ£o pode ser nulo ou vazio.",
					e.getMessage());
		}
		try {
			musitecaTest.addAlbum(darkSide);
			darkSide.addMusica("Money", 5, "Progressive");
			musitecaTest.getMusicaFromAlbuns(null);
			fail();

		} catch (Exception e) {
			assertEquals("Titulo da musica nao pode ser nulo ou vazio.",
					e.getMessage());
		}
	}

	@Test
	public void testInvalidosPlaylists() {

		try {
			musitecaTest.addPlaylist(null);
			fail();

		} catch (Exception e) {
			assertEquals("Playlist nao pode ser nula.", e.getMessage());
		}
		try {
			musitecaTest.addPlaylist(academia);
			musitecaTest.getPlaylist("  ");
			fail();

		} catch (Exception e) {
			assertEquals("Nome da playlist nao pode ser nulo ou vazio.",
					e.getMessage());
		}
		try {
			musitecaTest.addMusicaToPlaylist("De Boa", "fgshd", 1);
			fail();

		} catch (Exception e) {
			assertEquals("Album nao pertence ao Perfil especificado.",
					e.getMessage());
		}
		try {
			musitecaTest.addAlbum(darkSide);
			darkSide.addMusica("Money", 5, "Progressive");
			musitecaTest.addMusicaToPlaylist("De Boa",
					"The Dark Side of The Moon", 2);
			fail();

		} catch (Exception e) {
			assertEquals(
					"Musica nao pertence ao Album do Perfil especificado.",
					e.getMessage());
		}
		try {
			musitecaTest.addAlbum(darkSide);
			darkSide.addMusica("Money", 5, "Progressive");
			musitecaTest.addMusicaToPlaylist(null, "The Dark Side of The Moon",
					1);
			fail();

		} catch (Exception e) {
			assertEquals("Nome da playlist nao pode ser nulo ou vazio.",
					e.getMessage());
		}
	}

	@Test
	public void testSortedAlbuns() {
		try {
			musitecaTest.addAlbum(turnBlue);
			musitecaTest.addAlbum(albumTeste);
			musitecaTest.addAlbum(darkSide);
			musitecaTest.addAlbum(albumTeste2);
			musitecaTest.addAlbum(albumTeste3);

			turnBlue.addMusica("Weight of Love", 4, "Pop-Rock");
			turnBlue.addMusica("Fever", 3, "Pop-Rock");
			darkSide.addMusica("Money", 5, "Progressive");

			assertEquals(
					"Albuns:"
							+ "\nArtista: Eu - Titulo: Album Teste - Ano: 1901"
							+ "\nArtista: Eu - Titulo: The Dark Side of The Moon - Ano: 1973"
							+ "\nArtista: Pink Floyd - Titulo: The Dark Side of The Moon - Ano: 1973"
							+ "\nArtista: The Black Keys - Titulo: Turn Blue - Ano: 2011"
							+ "\nArtista: The Black Keys - Titulo: Turn Blue - Ano: 2011"
							+ "\nAlbuns favoritos:"
							+ "\nArtista: Eu - Titulo: Album Teste - Ano: 1901"
							+ "\nArtista: The Black Keys - Titulo: Turn Blue - Ano: 2011"
							+ "\nArtista: The Black Keys - Titulo: Turn Blue - Ano: 2011\n",
					musitecaTest.sortedAlbuns());

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro");
		}
	}

	@Test
	public void testEquals() {
		try {
			musitecaTest.addAlbum(turnBlue);
			turnBlue.addMusica("Weight of Love", 4, "Pop-Rock");
			turnBlue.addMusica("Fever", 3, "Pop-Rock");
			turnBlue.addMusica("Turn Blue", 5, "Pop-Rock");

			musitecaTest.addMusicaToPlaylist("De Boa", "Turn Blue", 1);
			musitecaTest.addMusicaToPlaylist("Academia", "Turn Blue", 2);

			Musiteca musitecaEquals = new Musiteca();
			musitecaEquals.addAlbum(turnBlue);
			musitecaEquals.addMusicaToPlaylist("De Boa", "Turn Blue", 1);
			musitecaEquals.addMusicaToPlaylist("Academia", "Turn Blue", 2);

			assertEquals(musitecaEquals, musitecaTest);
			assertTrue(musitecaTest.equals(musitecaEquals));

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro.");
		}
	}

	@Test
	public void testToString() {
		try {
			musitecaTest.addAlbum(turnBlue);
			turnBlue.addMusica("Weight of Love", 4, "Pop-Rock");
			turnBlue.addMusica("Fever", 3, "Pop-Rock");
			turnBlue.addMusica("Turn Blue", 5, "Pop-Rock");

			musitecaTest.addMusicaToPlaylist("De Boa", "Turn Blue", 1);
			musitecaTest.addMusicaToPlaylist("Academia", "Turn Blue", 2);

			assertEquals(
					"\nArtista: The Black Keys - Titulo: Turn Blue - Ano: 2011"
							+ "\nNome da Playlist: Academia"
							+ "\nMusicas:"
							+ "\nFever - Pop-Rock - Duracao: 3min"
							+ "\nNome da Playlist: De Boa"
							+ "\nMusicas:"
							+ "\nWeight of Love - Pop-Rock - Duracao: 4min",
					musitecaTest.toString());

		} catch (Exception e) {
			fail("Nao deveria ter ocorrido nenhum erro.");
		}
	}
}