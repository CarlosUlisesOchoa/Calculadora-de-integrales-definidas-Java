/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import de.congrace.exp4j.*;

/**
 *
 * @author Gerson
 */
public class Funcion {

    protected ExpressionBuilder parser;

    public Funcion() {
    }

    public Funcion(String funcion, boolean reporte) {
        if (reporte) {
            System.out.println("");
            System.out.println("Funcion: " + funcion);
        }
        this.parser = new ExpressionBuilder(funcion);



    }

    public Funcion(String funcion) {

        System.out.println("");
        System.out.println("Funcion: " + funcion);

        this.parser = new ExpressionBuilder(funcion);



    }

    public Double evaluar(double valor) {
        Double resultado = null;
        try {
            resultado = this.evaluar(valor, false);
        } catch (UnknownFunctionException | UnparsableExpressionException ex) {
        }

        return resultado;
    }

    public Double evaluar(double x, double y) {
        Double resultado = null;
        try {
            resultado = this.evaluar(x, y, false);
        } catch (Exception ex) {
        }

        return resultado;
    }

    public Double evaluar() {
        Double resultado = null;
        try {
            resultado = this.evaluar(false);
        } catch (Exception ex) {
        }
        return resultado;
    }

    public double evaluar(double x, double y, boolean error) throws UnknownFunctionException, UnparsableExpressionException {
        double resultado = 0;
        Calculable calc = this.parser.withVariable("x", x).withVariable("y", y).build();
        resultado = calc.calculate();



        return resultado;
    }

    public double evaluar(double valor, boolean error) throws UnknownFunctionException, UnparsableExpressionException {
        double resultado = 0;
        Calculable calc = this.parser.withVariable("x", valor).build();
        resultado = calc.calculate();



        return resultado;
    }

    public double evaluar(boolean error) throws UnknownFunctionException, UnparsableExpressionException {
        return this.evaluar(0, error);
    }
}
