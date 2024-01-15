package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class TestaProduto {

    @Test
    fun aoCriarUmProdutoComOValorCertoOValorDeveriaSerValido() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorValido

        Assert.assertEquals(true, valorEhValido)
    }

    @Test
    fun seOValorForMaiorQueCemReaisDeveDarErro() {
        //Arrange
        val produtoInvalido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("101.99")
        )

        //Act
        val valorEhInvalido = produtoInvalido.valorValido

        //Assert
        Assert.assertEquals(false, valorEhInvalido)
    }

    @Test
    fun seOValorForMenorOuIgualAZeroDeveDarErro() {
        val produtoInvalido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("0.00")
        )

        val valorEhInvalido = produtoInvalido.valorValido

        Assert.assertEquals(false, valorEhInvalido)
    }
}