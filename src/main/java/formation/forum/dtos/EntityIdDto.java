package formation.forum.dtos;

public class EntityIdDto {


  private Long id;

  protected EntityIdDto() {
    //
  }
  public EntityIdDto(Long id){
    this.id = id;
  }

  public Long getId() {
    return id;
  }


}
