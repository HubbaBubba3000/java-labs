import java.util.List;
import java.util.ArrayList;
public class Section {
    public final String name;
    public Emploee leader;
    public List<Emploee> emploees;

    public Section(String name, Emploee leader) {
        this.name = name;
        this.leader = leader;
        this.emploees = new ArrayList<Emploee>();
        this.emploees.add(leader);
    }

    public void AddEmploee(Emploee e) {
        this.emploees.add(e);
    }

    public void MakeLeader(Emploee e) {
        this.leader = e;
    }

    public String getEmploeesList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список сотрудников отдела ").append(this.name).append(":\n -");
        for (Emploee e : this.emploees)
            sb.append(e.name).append(" \n -");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s начальник отдела %s",leader.name, name);
    }
}
