package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UsuarioRepositoryTest {
    //coEvery -> usado para coroutines

    private val mockDao = mockk<UsuarioDao>()
    private val usuario: Usuario = Usuario(
        id = "teste",
        email = "emailValido@email.com",
        senha = "senhaForte"
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `deve salvar um usuario quando chamado o salva do repository`() = runTest {
        coEvery { mockDao.salva(usuario) } returns Unit
        val usuarioRepository = UsuarioRepository(mockDao)

        usuarioRepository.salva(usuario)

        coVerify(exactly = 1) {
            mockDao.salva(usuario)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `deve logar um usuario quando chamado o autentica do repository`() = runTest {
        coEvery { mockDao.autentica(usuarioId = usuario.id, senha = usuario.senha) } returns mockk()
        val usuarioRepository = UsuarioRepository(mockDao)


        usuarioRepository.autentica(usuarioId = usuario.id, senha = usuario.senha)

        coVerify(exactly = 1) {
            mockDao.autentica(usuarioId = usuario.id, senha = usuario.senha)
        }
    }
}