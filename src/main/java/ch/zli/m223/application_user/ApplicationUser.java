package ch.zli.m223.application_user;

import javax.persistence.*;

import javax.persistence.GeneratedValue;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class ApplicationUser {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Schema(readOnly = true)
        private Long id;

        @Column(nullable = false)
        private String vorname;

        @Column(nullable = false)
        private String nachname;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setVorname() {
                this.vorname = vorname;
        }

        public String getVorname(String vorname) {
                return vorname;
        }

        public void setNachname() {
                this.nachname = nachname;
        }

        public String getNachname(String nachname) {
                return nachname;
        }

        public void setEmail() {
                this.email = email;
        }

        public String getEmail(String email) {
                return email;
        }
}
