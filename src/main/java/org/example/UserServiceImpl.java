package org.example;

public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    public void assignPassword(AccountUser user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    public UserServiceImpl(UserDAO dao, SecurityService security) {
        this.userDAO = dao;
        this.securityService = security;
    }
}
