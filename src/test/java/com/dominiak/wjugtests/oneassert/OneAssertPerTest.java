package com.dominiak.wjugtests.oneassert;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OneAssertPerTest {

    @Test // Ok
    public void constructorShouldCreateNewPersonObjectWithGoodDefaults() throws Exception {
        Account person = new Account();

        assertThat(person.firstName).isEqualTo("John");
        assertThat(person.lastName).isEqualTo("Doe");
        assertThat(person.invoices).isEmpty();
    }

    @Test // bad - two reasons to fail, 2 or more assertions, only first assertion checked, maybe it's 5 bugs?
    public void constructorShouldCreateNewPersonObjectWithGoodDefaults_2() throws Exception {
        Account person = new Account();
        person.setHobby("soccer");
        person.setAge(16);
        person.setFirstName("Peter");

        assertThat(person.firstName).isEqualTo("Peter");
        assertThat(person.lastName).isEqualTo("Doe");
        assertThat(person.invoices).isEmpty();
        assertThat(person.hobby).isEqualTo("soccer");
    }

    static class Account {
        private final List<String> invoices;
        private String firstName;
        private String lastName;
        private String hobby;
        private int age;

        public Account() {
            this.firstName = "John";
            this.lastName = "Doe";
            this.invoices = Collections.emptyList();
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getHobby() {
            return hobby;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }
}
