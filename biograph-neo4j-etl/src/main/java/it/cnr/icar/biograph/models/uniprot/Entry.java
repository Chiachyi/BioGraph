//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.12.01 alle 07:40:41 AM CET 
//


package it.cnr.icar.biograph.models.uniprot;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accession" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="protein" type="{http://uniprot.org/uniprot}proteinType"/>
 *         &lt;element name="gene" type="{http://uniprot.org/uniprot}geneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="organism" type="{http://uniprot.org/uniprot}organismType"/>
 *         &lt;element name="organismHost" type="{http://uniprot.org/uniprot}organismType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="geneLocation" type="{http://uniprot.org/uniprot}geneLocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://uniprot.org/uniprot}referenceType" maxOccurs="unbounded"/>
 *         &lt;element name="comment" type="{http://uniprot.org/uniprot}commentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dbReference" type="{http://uniprot.org/uniprot}dbReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="proteinExistence" type="{http://uniprot.org/uniprot}proteinExistenceType"/>
 *         &lt;element name="keyword" type="{http://uniprot.org/uniprot}keywordType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feature" type="{http://uniprot.org/uniprot}featureType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="evidence" type="{http://uniprot.org/uniprot}evidenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sequence" type="{http://uniprot.org/uniprot}sequenceType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dataset" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Swiss-Prot"/>
 *             &lt;enumeration value="TrEMBL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="created" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="modified" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accession",
    "name",
    "protein",
    "gene",
    "organism",
    "organismHost",
    "geneLocation",
    "reference",
    "comment",
    "dbReference",
    "proteinExistence",
    "keyword",
    "feature",
    "evidence",
    "sequence"
})
@XmlRootElement(name = "entry")
public class Entry {

    @XmlElement(required = true)
    protected List<String> accession;
    @XmlElement(required = true)
    protected List<String> name;
    @XmlElement(required = true)
    protected ProteinType protein;
    protected List<GeneType> gene;
    @XmlElement(required = true)
    protected OrganismType organism;
    protected List<OrganismType> organismHost;
    protected List<GeneLocationType> geneLocation;
    @XmlElement(required = true)
    protected List<ReferenceType> reference;
    @XmlElement(nillable = true)
    protected List<CommentType> comment;
    protected List<DbReferenceType> dbReference;
    @XmlElement(required = true)
    protected ProteinExistenceType proteinExistence;
    protected List<KeywordType> keyword;
    protected List<FeatureType> feature;
    protected List<EvidenceType> evidence;
    @XmlElement(required = true)
    protected SequenceType sequence;
    @XmlAttribute(name = "dataset", required = true)
    protected String dataset;
    @XmlAttribute(name = "created", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar created;
    @XmlAttribute(name = "modified", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar modified;
    @XmlAttribute(name = "version", required = true)
    protected int version;

    /**
     * Gets the value of the accession property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accession property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccession().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccession() {
        if (accession == null) {
            accession = new ArrayList<String>();
        }
        return this.accession;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getName() {
        if (name == null) {
            name = new ArrayList<String>();
        }
        return this.name;
    }

    /**
     * Recupera il valore della proprietà protein.
     * 
     * @return
     *     possible object is
     *     {@link ProteinType }
     *     
     */
    public ProteinType getProtein() {
        return protein;
    }

    /**
     * Imposta il valore della proprietà protein.
     * 
     * @param value
     *     allowed object is
     *     {@link ProteinType }
     *     
     */
    public void setProtein(ProteinType value) {
        this.protein = value;
    }

    /**
     * Gets the value of the gene property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gene property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGene().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneType }
     * 
     * 
     */
    public List<GeneType> getGene() {
        if (gene == null) {
            gene = new ArrayList<GeneType>();
        }
        return this.gene;
    }

    /**
     * Recupera il valore della proprietà organism.
     * 
     * @return
     *     possible object is
     *     {@link OrganismType }
     *     
     */
    public OrganismType getOrganism() {
        return organism;
    }

    /**
     * Imposta il valore della proprietà organism.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganismType }
     *     
     */
    public void setOrganism(OrganismType value) {
        this.organism = value;
    }

    /**
     * Gets the value of the organismHost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organismHost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganismHost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganismType }
     * 
     * 
     */
    public List<OrganismType> getOrganismHost() {
        if (organismHost == null) {
            organismHost = new ArrayList<OrganismType>();
        }
        return this.organismHost;
    }

    /**
     * Gets the value of the geneLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geneLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneLocationType }
     * 
     * 
     */
    public List<GeneLocationType> getGeneLocation() {
        if (geneLocation == null) {
            geneLocation = new ArrayList<GeneLocationType>();
        }
        return this.geneLocation;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getReference() {
        if (reference == null) {
            reference = new ArrayList<ReferenceType>();
        }
        return this.reference;
    }

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentType }
     * 
     * 
     */
    public List<CommentType> getComment() {
        if (comment == null) {
            comment = new ArrayList<CommentType>();
        }
        return this.comment;
    }

    /**
     * Gets the value of the dbReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbReferenceType }
     * 
     * 
     */
    public List<DbReferenceType> getDbReference() {
        if (dbReference == null) {
            dbReference = new ArrayList<DbReferenceType>();
        }
        return this.dbReference;
    }

    /**
     * Recupera il valore della proprietà proteinExistence.
     * 
     * @return
     *     possible object is
     *     {@link ProteinExistenceType }
     *     
     */
    public ProteinExistenceType getProteinExistence() {
        return proteinExistence;
    }

    /**
     * Imposta il valore della proprietà proteinExistence.
     * 
     * @param value
     *     allowed object is
     *     {@link ProteinExistenceType }
     *     
     */
    public void setProteinExistence(ProteinExistenceType value) {
        this.proteinExistence = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeywordType }
     * 
     * 
     */
    public List<KeywordType> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<KeywordType>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the feature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeatureType }
     * 
     * 
     */
    public List<FeatureType> getFeature() {
        if (feature == null) {
            feature = new ArrayList<FeatureType>();
        }
        return this.feature;
    }

    /**
     * Gets the value of the evidence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceType }
     * 
     * 
     */
    public List<EvidenceType> getEvidence() {
        if (evidence == null) {
            evidence = new ArrayList<EvidenceType>();
        }
        return this.evidence;
    }

    /**
     * Recupera il valore della proprietà sequence.
     * 
     * @return
     *     possible object is
     *     {@link SequenceType }
     *     
     */
    public SequenceType getSequence() {
        return sequence;
    }

    /**
     * Imposta il valore della proprietà sequence.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType }
     *     
     */
    public void setSequence(SequenceType value) {
        this.sequence = value;
    }

    /**
     * Recupera il valore della proprietà dataset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataset() {
        return dataset;
    }

    /**
     * Imposta il valore della proprietà dataset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataset(String value) {
        this.dataset = value;
    }

    /**
     * Recupera il valore della proprietà created.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Imposta il valore della proprietà created.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Recupera il valore della proprietà modified.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModified() {
        return modified;
    }

    /**
     * Imposta il valore della proprietà modified.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModified(XMLGregorianCalendar value) {
        this.modified = value;
    }

    /**
     * Recupera il valore della proprietà version.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Imposta il valore della proprietà version.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /*
    public Vertex save(OrientGraphNoTx graph) {
    	if (getAccession().isEmpty())
    		return null;
    	
    	String fullName = ((protein.getRecommendedName() != null) && (protein.getRecommendedName().getFullName() != null)) ? protein.getRecommendedName().getFullName().getValue() : "";
    	
    	Vertex prot = graph.addVertex("class:protein",
    			//"modified", modified,
    			//"created", created,
    			"accession", accession.get(0),
    			"name", name.get(0),
    			"fullName", fullName
    			//"shortName", shortName,
    			//"version", version
    			);
    	
    	return prot;
    }
    */
}
