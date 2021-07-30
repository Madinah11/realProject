package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Attachment;
import uz.pdp.realproject.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
}
