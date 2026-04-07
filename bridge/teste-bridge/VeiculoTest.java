package padroesestruturais.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void deveCalcularCustoCarroComGasolina() {
        Veiculo veiculo = new Carro(1000f);
        veiculo.setCombustivel(new Gasolina());
        assertEquals(1300f, veiculo.calcularCusto());
    }

    @Test
    void deveCalcularCustoCarroComEtanol() {
        Veiculo veiculo = new Carro(1000f);
        veiculo.setCombustivel(new Etanol());
        assertEquals(1100f, veiculo.calcularCusto());
    }

    @Test
    void deveCalcularCustoMotoComGasolina() {
        Veiculo veiculo = new Moto(1000f);
        veiculo.setCombustivel(new Gasolina());
        assertEquals(300f, veiculo.calcularCusto());
    }

    @Test
    void deveCalcularCustoMotoComEtanol() {
        Veiculo veiculo = new Moto(1000f);
        veiculo.setCombustivel(new Etanol());
        assertEquals(100f, veiculo.calcularCusto());
    }
}
