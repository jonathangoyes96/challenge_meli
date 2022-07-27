package com.optic.challengemeli.data.model;

/*
 * MUESTRA INFORMACION DE LOS RESULTADOS CON PAGINACION DE UNA BUSQUEDA DE PRODUCTOS
 */
public class Paging{
    public int total;
    public int primary_results;
    public int offset;
    public int limit;

    public Paging() {
    }

    public Paging(int total, int primary_results, int offset, int limit) {
        this.total = total;
        this.primary_results = primary_results;
        this.offset = offset;
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrimary_results() {
        return primary_results;
    }

    public void setPrimary_results(int primary_results) {
        this.primary_results = primary_results;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
