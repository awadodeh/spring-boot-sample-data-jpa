/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static sample.data.jpa.ApplicationConstants.HOTEL_NAME_GRAPH;
import static sample.data.jpa.ApplicationConstants.REVIEW_NAME_GRAPH;


@NamedEntityGraph(
		name = HOTEL_NAME_GRAPH,
		attributeNodes = {
				@NamedAttributeNode("id"),
				@NamedAttributeNode("name"),
				@NamedAttributeNode("address"),
				@NamedAttributeNode("zip"),
				@NamedAttributeNode(value = "reviews", subgraph = REVIEW_NAME_GRAPH),
		},
		subgraphs = {
				@NamedSubgraph(
						name = REVIEW_NAME_GRAPH,
						attributeNodes = {
								@NamedAttributeNode("id"),
								@NamedAttributeNode("checkInDate"),
								@NamedAttributeNode("title"),
						}
				)
		}
)
@Entity
@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ")
	@SequenceGenerator(name = "HOTEL_SEQ", sequenceName = "HOTEL_SEQ", allocationSize = 10000)
	private Long id;

	@ManyToOne(optional = false)
	@NaturalId
	private City city;

	@Column(nullable = false)
	@NaturalId
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String zip;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
	private Set<Review> reviews;
}
