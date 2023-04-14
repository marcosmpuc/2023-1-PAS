package com.bcopstein.SistCalculoFreteP3.Dominio;

public class CalculadoraDeTransporte {

	public double calcularCustoParaEncomendaSimples(Cidade origem, Cidade destino, double pesoG) {
		double peso = converterDePesoG(pesoG);
		return calcularCustoBasico(origem, destino) +
				calcularAdicionalDePeso(peso) +
				calcularImposto();
	}
	
	public double calcularCustoBasico(Cidade origem, Cidade destino) {
		if (destino.equals(origem))
			return new SaoPaulo().getCustoBasico;
		
		double custoBasico;
		
		if (!destino.equals(new SaoPaulo())) {
			custoBasico += calcularCustoDeEntrega(origem, new SaoPaulo());
			custoBasico += calcularCustoDeEntrega(new SaoPaulo(), destino);
		} else {
			custoBasico = calcularCustoDeEntrega(origem, destino);
		}
		
		return custoBasico - getPromocaoVigente();
	}
	
	public double calcularCustoDeEntrega(Cidade origem, Cidade destino) {
		double custoPoa = 25;
		double custoSp = 10;
		double custoFp = 20;
		double custoC = 15;
		double custoEntrega = 2;

		if(origem.getNome()=="Porto Alegre"){
			if(destino.getNome()=="Florianópolis"){
				return  custoPoa+custoSp+custoFp;
			}
			else if(destino.getNome()=="Curitiba"){
				return custoC+custoPoa+custoSp;
			}
			else if(destino.getNome()=="Porto Alegre"){
				return custoPoa+custoSp;
		}
		}
		 if(origem.getNome()=="Curitiba"){
			if(destino.getNome()=="Porto Alegre"){
				return  custoPoa+custoSp+custoC;
			}
			else if(destino.getNome()=="Florianópolis"){
				return custoC+custoFp+custoSp;
			}
			else if(destino.getNome()=="Curitiba"){
				return custoC+custoSp;
		}
		}
		if(origem.getNome()=="Florianópolis"){
			if(destino.getNome()=="Porto Alegre"){
				return  custoPoa+custoSp+custoFp;
			}
			else if(destino.getNome()=="Curitiba"){
				return custoC+custoFp+custoSp;
			}
			else if(destino.getNome()=="Florianópolis"){
					return custoFp+custoSp;
			}
		}
		
		return -1;
	}
	
	public double calcularImposto(double custoBasico) {
		/*if (imposto)*/
		/*else*/ return custoBasico * 0.05;
	}
	
	public double getPromocaoVigente() {
		double producaoVigente = 0;

		return producaoVigente;
	}
	
	public double converterDePesoG(double pesoG) {
		return Math.ceil(pesoG / 1000);
	}
	
	public double calcularAdicionalDePeso(double peso) {
		double adicional = 0;
		
		// lógica aqui
		
		return adicional - getPromocaoVigente();
	}
	
}
