package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTests {

    @Test
    fun `deve retornar verdadeiro quando o valor for valido`() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorValido

        valorEhValido.shouldBeTrue()
    }

    @Test
    fun `deve retornar falso quando o valor for maior que cem`() {
        //Arrange
        val produtoInvalido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("101.99")
        )

        //Act
        val valorEhInvalido = produtoInvalido.valorValido

        //Assert
        valorEhInvalido.shouldBeFalse()
    }

    @Test
    fun `deve retornar falso quando o valor for menor ou igual a zero`() {
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "doce",
            valor = BigDecimal("0")
        )

        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "azeda",
            valor = BigDecimal("-10.00")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorValido


        valorIgualAZeroEhValido.shouldBeFalse()
        valorMenorQueZeroEhValido.shouldBeFalse()
    }
}