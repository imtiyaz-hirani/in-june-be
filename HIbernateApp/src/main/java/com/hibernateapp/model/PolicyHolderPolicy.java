package com.hibernateapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policyholder_policy")
public class PolicyHolderPolicy {

	@Id //this will make id as Primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) //this makes it auto_incremental 
	private int id;
	private LocalDate dateOfRegistration; 
	private double premium;
	@OneToOne
	private PolicyHolder policyHolder; //condition
	@ManyToOne
	private Policy policy; //select 
//select php.policy from PolicyHolderPolicy php where php.policyHolder.id=:id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "PolicyHolderPolicy [id=" + id + ", dateOfRegistration=" + dateOfRegistration + ", premium=" + premium
				+ ", policyHolder=" + policyHolder + ", policy=" + policy + "]";
	} 
	
	
}
