package service;

import domain.Angajat;
import repository.AngajatDbRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Service {
    private final AngajatDbRepository repo;
    public Service(AngajatDbRepository repo) {this.repo = repo;}
    public Iterable<Angajat> getAllService(){ return repo.findAll();}
    public Angajat getOneService(String t){ return repo.getOne(t);}
    public List<Angajat> filtrareAngajatiDupaPost(String post){
        Set<Angajat> angajati = (Set<Angajat>) repo.findAll();
        return angajati.stream().filter(x -> Objects.equals(x.getPost(), post)).collect(Collectors.toList());
    }
    public List<Angajat> filtrareAngajatiDupaPostSiSalariu(String post){
        Set<Angajat> angajati =(Set<Angajat>) repo.findAll();
        return angajati.stream().filter(x-> Objects.equals(x.getPost(), post) && x.getSalariu()>5000).collect(Collectors.toList());
    }

    public List<Angajat> filtrareAngajatiDupaNumeSiPrenume(String nume, String prenume){
        Set<Angajat> set = (Set<Angajat>) repo.findAll();
        return set.stream().filter(x -> x.getNume().startsWith(nume) && x.getPrenume().startsWith(prenume)).toList();
    }

    public List<Angajat> sortareAngajatiDupaNumeSiPrenume(){
        Set<Angajat> set = (Set<Angajat>) repo.findAll();
        List<Angajat> filtratiDupaNume = set.stream().sorted(Comparator.comparing(Angajat::getNume).reversed()).toList();
        return filtratiDupaNume.stream().sorted(Comparator.comparing(Angajat::getPrenume).reversed()).toList();
    }

    public List<Angajat> sortareAngajatiDupaPostCrescator(){
        Set<Angajat> set = (Set<Angajat>) repo.findAll();
        return set.stream().sorted(Comparator.comparing(Angajat::getPost)).toList();
    }
    public List<Angajat> sortareAngajatiDupaSalariuDescrescator() {
        Set<Angajat> set = (Set<Angajat>) repo.findAll();
        return set.stream().sorted(Comparator.comparing(Angajat::getSalariu).reversed()).toList();
    }
}
