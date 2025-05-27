package com.e_commerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class Admin extends User {

}
