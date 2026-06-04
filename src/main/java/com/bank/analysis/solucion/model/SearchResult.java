package com.bank.analysis.solucion.model;

/**
 * Record inmutable que encapsula el resultado de una operación de búsqueda.
 * <p>
 * <b>Propósito educativo:</b> Demostrar el uso de Records de Java 21 para DTOs
 * inmutables que transportan datos entre capas sin lógica de negocio.
 * <p>
 * Incluye tanto la transacción encontrada como métricas de rendimiento de la
 * búsqueda, permitiendo a los estudiantes analizar la eficiencia de diferentes
 * algoritmos.
 *
 * @param transaction la transacción encontrada, o {@code null} si no se
 *                    encontró
 * @param nanos       tiempo de ejecución en nanosegundos
 * @param comparisons número de comparaciones realizadas durante la búsqueda
 */
public record SearchResult(
        Transaction transaction,
        long nanos,
        int comparisons) {

    /**
     * Constructor canónico con validación.
     *
     * @param transaction la transacción encontrada (puede ser null)
     * @param nanos       tiempo en nanosegundos (debe ser >= 0)
     * @param comparisons número de comparaciones (debe ser >= 0)
     * @throws IllegalArgumentException si nanos o comparisons son negativos
     */
    public SearchResult {
        if (nanos < 0) {
            throw new IllegalArgumentException("nanos no puede ser negativo: " + nanos);
        }
        if (comparisons < 0) {
            throw new IllegalArgumentException("comparisons no puede ser negativo: " + comparisons);
        }
    }

    /**
     * Indica si la búsqueda encontró una transacción.
     *
     * @return {@code true} si se encontró la transacción
     */
    public boolean encontrada() {
        return transaction != null;
    }

    /**
     * Representación legible del resultado de búsqueda, útil para reportes.
     *
     * @return resumen formateado del resultado
     */
    @Override
    public String toString() {
        return String.format("SearchResult{encontrada=%s, nanos=%,d, comparaciones=%,d}",
                encontrada(), nanos, comparisons);
    }
}
