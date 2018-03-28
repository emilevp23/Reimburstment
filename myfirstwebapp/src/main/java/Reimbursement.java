import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
    private int id = 0;
    private double amount = 0;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description ="";
    private Blob receipt;
    private int author = 0;
    private int resolver = 0;
    private int status = 0;
    private int type = 0;
    private String author_first_name ="";
    private String author_last_name ="";
    private String status_name ="";
    private String resolver_first_name="";
    private String resolver_last_name="";
    private String type_name="";
    private String receipt_string = "";

    public String getReceipt_string() {
        return receipt_string;
    }

    public void setReceipt_string(String receipt_string) {
        this.receipt_string = receipt_string;
    }

    public Reimbursement(double amount, String receipt_string, int type, String type_name) {
        this.amount=amount;
        this.receipt_string=receipt_string;
        this.type=type;
        this.type_name=type_name;
    }


    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String getResolver_first_name() {
        return resolver_first_name;
    }

    public void setResolver_first_name(String resolver_first_name) {
        this.resolver_first_name = resolver_first_name;
    }

    public String getResolver_last_name() {
        return resolver_last_name;
    }

    public void setResolver_last_name(String resolver_last_name) {
        this.resolver_last_name = resolver_last_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }


    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Reimbursement() {

    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                '}';
    }

    public Reimbursement(int reimburtmentid, double amount, Timestamp submitted,
                         Timestamp resolved, String description, Blob receipt, int author, int resolver, int status, int type) {
        this.id = reimburtmentid;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getReceipt() {
        return receipt;
    }

    public void setReceipt(Blob receipt) {
        this.receipt = receipt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
