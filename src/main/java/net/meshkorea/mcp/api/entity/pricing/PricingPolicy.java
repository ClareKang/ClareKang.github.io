package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.common.Money;
import net.meshkorea.mcp.api.entity.execption.PricingNotApplicableException;
import net.meshkorea.mcp.api.entity.order.OrderAddress;

import javax.persistence.*;

/**
 * Created by jihunlee on 2016. 1. 28..
 */
@Entity
@Table(name = "pricing_policy")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class PricingPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract Money calculatePrice(OrderAddress origin, OrderAddress dest) throws PricingNotApplicableException;

	public abstract boolean isApplicable(OrderAddress origin, OrderAddress dest);
}
