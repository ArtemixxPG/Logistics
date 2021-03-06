package logistics.entityes;

import logistics.entityes.HistoricalDemand;
import logistics.entityes.Icon;
import logistics.entityes.Locations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "inclusion")
    private String inclusion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "icon", referencedColumnName = "id")
    private Icon icon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location", referencedColumnName = "name")
    private Locations locations;

    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    private HistoricalDemand historicalDemand;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site_state")
//    private List<SiteState> siteStates;

    public Customers(){}

    public HistoricalDemand getHistoricalDemand() {
        return historicalDemand;
    }

    public void setHistoricalDemand(HistoricalDemand historicalDemand) {
        this.historicalDemand = historicalDemand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getInclusion() {
        return inclusion;
    }

    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }

    public Locations getLocation() {
        return locations;
    }

    public void setLocation(Locations locations) {
        this.locations = locations;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
