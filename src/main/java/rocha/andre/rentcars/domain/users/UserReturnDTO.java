package rocha.andre.rentcars.domain.users;

public record UserReturnDTO(Long id,
                            String login) {

    public UserReturnDTO(User user) {
        this(user.getId(), user.getLogin());
    }
}