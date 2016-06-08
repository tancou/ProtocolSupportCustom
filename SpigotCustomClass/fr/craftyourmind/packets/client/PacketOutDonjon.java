/*    */ package fr.craftyourmind.packets.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.server.v1_9_R2.Packet;
/*    */ import net.minecraft.server.v1_9_R2.PacketDataSerializer;
/*    */ import net.minecraft.server.v1_9_R2.PacketListener;
/*    */ 
/*    */ public class PacketOutDonjon
/*    */   implements Packet<PacketListener>
/*    */ {
/*    */   public static final String DELIMITER = "";
/*    */   public static final int WORLD = 0;
/*    */   public int action;
/*    */   public String names;
/*    */   public int playerNb;
/*    */ 
/*    */   public PacketOutDonjon()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PacketOutDonjon(int action, String names, int playerNb)
/*    */   {
/* 24 */     this.action = action;
/* 25 */     this.names = names;
/* 26 */     this.playerNb = playerNb;
/*    */   }
/*    */ 
/*    */   public void a(PacketDataSerializer arg0) throws IOException {
/* 30 */     this.action = arg0.readInt();
/* 31 */     this.names = arg0.e(32767);
/* 32 */     this.playerNb = arg0.readInt();
/*    */   }
/*    */ 
/*    */   public void a(PacketListener arg0) {
/*    */   }
/*    */ 
/*    */   public void b(PacketDataSerializer arg0) throws IOException {
/* 39 */     arg0.writeInt(this.action);
/* 40 */     arg0.a(this.names);
/* 41 */     arg0.writeInt(this.playerNb);
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.packets.client.PacketOutDonjon
 * JD-Core Version:    0.6.2
 */