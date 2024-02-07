package br.com.alura.orgs

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    CadastroUsuarioTeste::class,
    LoginActivityTest::class
)
class LoginSuite

@RunWith(Suite::class)
@SuiteClasses(
    CadastroUsuarioTeste::class,
    LoginActivityTest::class,
    ProdutoTelasTest::class
)
class ProdutoSuite