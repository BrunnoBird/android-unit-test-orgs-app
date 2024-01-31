package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

class ProdutoRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `deve chamar o dao quando salva um produto`() = runTest {
        val dao = mockk<ProdutoDao>()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Banana",
            descricao = "Prata",
            valor = BigDecimal("6.99")

        )

        coEvery {
            dao.salva(produto)
        }.returns(Unit)

        produtoRepository.salva(produto)

        //Verifica se algo é chamado
        coVerify {
            dao.salva(produto)
        }
    }
}