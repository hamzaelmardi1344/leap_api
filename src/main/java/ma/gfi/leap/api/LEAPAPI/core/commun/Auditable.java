package ma.gfi.leap.api.LEAPAPI.core.commun;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@CreatedBy
	private U createdBy;
	
	@CreatedDate
	@Column(updatable = false )
	private Date createdate;
	
	@LastModifiedBy
	private U lastmodifieBy;
	@LastModifiedDate
	private Date lastModifieddate;
	public U getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public U getLastmodifieBy() {
		return lastmodifieBy;
	}
	public void setLastmodifieBy(U lastmodifieBy) {
		this.lastmodifieBy = lastmodifieBy;
	}
	public Date getLastModifieddate() {
		return lastModifieddate;
	}
	public void setLastModifieddate(Date lastModifieddate) {
		this.lastModifieddate = lastModifieddate;
	}

}
	