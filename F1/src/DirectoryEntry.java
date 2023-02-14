public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof DirectoryEntry){
            DirectoryEntry otherEntry = (DirectoryEntry) o;
            return otherEntry.name.equals(this.name);
        }
        return false;
    }
    
}
