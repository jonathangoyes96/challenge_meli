package com.optic.challengemeli.data.model;

/*
 * CARACTERISTICAS DE UN PRODUCTO
 */
public class Attribute{
    public String id;
    public String name;
    public String value_id;
    public String value_name;
    public String attribute_group_id;
    public String attribute_group_name;

    public Attribute() {
    }

    public Attribute(String id, String name, String value_id, String value_name, String attribute_group_id, String attribute_group_name) {
        this.id = id;
        this.name = name;
        this.value_id = value_id;
        this.value_name = value_name;
        this.attribute_group_id = attribute_group_id;
        this.attribute_group_name = attribute_group_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue_id() {
        return value_id;
    }

    public void setValue_id(String value_id) {
        this.value_id = value_id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public String getAttribute_group_id() {
        return attribute_group_id;
    }

    public void setAttribute_group_id(String attribute_group_id) {
        this.attribute_group_id = attribute_group_id;
    }

    public String getAttribute_group_name() {
        return attribute_group_name;
    }

    public void setAttribute_group_name(String attribute_group_name) {
        this.attribute_group_name = attribute_group_name;
    }
}