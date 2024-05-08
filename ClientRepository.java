import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientRepository {
    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Optional<Client> findClient(Predicate<Client> predicate) {
        return clients.stream().filter(predicate).findFirst();
    }

    public List<Client> findClients(Predicate<Client> predicate) {
        return clients.stream().filter(predicate).collect(Collectors.toList());
    }

    public int getSize() {
        return clients.size();
    }
}