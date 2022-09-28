package recipes.business;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "recipes")
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "ingredients")
    @ElementCollection
    @Size(min = 1)
    private ArrayList<String> ingredients;

    @Column(name = "directions")
    @ElementCollection
    @Size(min = 1)
    private ArrayList<String> directions;

}
