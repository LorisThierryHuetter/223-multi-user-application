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

        @Schema(readOnly = true)
        private boolean adminRights;

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

        public boolean getAdminRights() {
                return adminRights;
        }

        public void setAdminRights(boolean adminRights) {
                this.adminRights = adminRights;
        }

        public void setVorname(String vorname) {
                this.vorname = vorname;
        }

        public String getVorname() {
                return vorname;
        }

        public void setNachname(String nachname) {
                this.nachname = nachname;
        }

        public String getNachname() {
                return nachname;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getEmail() {
                return email;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPassword() {
                return password;
        }

}
