package ma.mundia.patientsmvc;

import ma.mundia.patientsmvc.entities.Patient;
import ma.mundia.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    //@Bean //Ne plus executer la methode
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null, "Hassan", new Date(), false, 122)
            );
            patientRepository.save(
                    new Patient(null, "Mohammed", new Date(), true, 321)
            );
            patientRepository.save(
                    new Patient(null, "Yasmine", new Date(), true, 165)
            );
            patientRepository.save(
                    new Patient(null, "Hanae", new Date(), false, 132)
            );

            //Afficher la liste des patients:
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
