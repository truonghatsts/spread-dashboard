package io.stably.spreaddashboard.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Spread {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
}
