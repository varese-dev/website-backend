package fullstack.rest.model;

import fullstack.persistence.model.Role;

public class AdminResponse extends UserResponse {
    private String role;

    public AdminResponse(String name, String surname, String email, String phone, Role role) {
        super(name, surname, email, phone, role);
    }
}
