public class TenantList extends ObjectList {
    public TenantList(int size) {
        super(size);
    }

    public Tenant getTenant(int index) {
        return (Tenant) getObject(index);
    }

    public Tenant search(int roomNumber) {
        for (int i = 0; i < getTotal(); i++) {
            Tenant tenant = getTenant(i);
            if (tenant.getRoom() == roomNumber) {
                return tenant;
            }
        }
        return null;
    }

    public boolean removeTenant(int roomNumber) {
        Tenant tenant = search(roomNumber);
        if (tenant == null) {
            return false;
        }

        return false;
    }
}

