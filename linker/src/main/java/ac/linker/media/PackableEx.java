/**
* Original Code
* https://github.com/AgoraIO/Tools/blob/master/DynamicKey/AgoraDynamicKey/java/src/main/java/io/agora/media/PackableEx.java
*/

package ac.linker.media;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
