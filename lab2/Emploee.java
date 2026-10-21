public class Emploee {
    public final String name;
    public Section section;

    public Emploee(String name,Section section) {
        this(name);
        this.section = section;
        section.AddEmploee(this);
    }
    public Emploee(String name) {
        this.name = name;
        section = null;
    }

    @Override
    public String toString() {
        if (section == null)
            return name + "не работает в отделе";
        if (this == section.leader)
            return section.toString();
        return String.format("%s работает в отделе %s, начальник которого %s", name, section.name, section.leader.name);
    }
}
