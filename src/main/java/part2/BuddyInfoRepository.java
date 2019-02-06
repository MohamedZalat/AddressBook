package part2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy.json")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

}
