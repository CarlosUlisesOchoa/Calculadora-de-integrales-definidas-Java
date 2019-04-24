package metodos;

import funcion.*;

public class Simpson extends Base {

    public Simpson() {
        this.espaciado = 0;
        this.decimales = 10;
    }

        public Double evaluar(Funcion funcion, double a, double b, int n) {
        
        Double resultado = funcion.evaluar(a);


        if(resultado != null) {
        
            double h = (b - a) / n;

            double partes_pares = 0, partes_impares = 0;
            for (int i = 1; i < n; i++) {
                if ((i % 2) == 0) {
                    partes_pares += funcion.evaluar(a + i * h);
                } else {
                    partes_impares += funcion.evaluar(a + i * h);
                }
            }
            resultado += (2 * partes_pares);
            resultado += (4 * partes_impares);

            resultado += funcion.evaluar(b);
            resultado *= ((b - a) / (3 * n));
        }

        return resultado;

    }
}
