package ac.linker.media;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
