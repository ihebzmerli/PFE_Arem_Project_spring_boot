package com.loizenai.jwtauthentication.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "det_prep", schema = "seratest")
public class DetPrep implements Serializable{

    @Id
    @Column(name = "id_prep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String zone;
    private String prepara;
    //FK_KEYS***********************

/*    
    @OneToMany(mappedBy = "detprep_chariot", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Chariot> numChars;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "NUM_BON_PREP", nullable = true)
    private BonPrep bonprep;

*/

    //END FK_KEYS************************

    public DetPrep() {

    }

    public DetPrep(long id, String zone, String prepara) {
        this.id = id;
        this.zone = zone;
        this.prepara = prepara;
    }

    public DetPrep(String zone, String prepara) {
        this.zone = zone;
        this.prepara = prepara;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ZONE")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "PREPARA")
    public String getPrepara() {
        return prepara;
    }

    public void setPrepara(String prepara) {
        this.prepara = prepara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetPrep detPrep = (DetPrep) o;
        return id == detPrep.id &&
                Objects.equals(zone, detPrep.zone) &&
                Objects.equals(prepara, detPrep.prepara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zone, prepara);
    }

    @Override
    public String toString() {
        return "DetPrep{" +
                "id=" + id +
                ", zone='" + zone + '\'' +
                ", prepara='" + prepara + '\'' +
                '}';
    }
}
