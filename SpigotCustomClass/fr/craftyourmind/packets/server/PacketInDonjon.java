/*    */ package fr.craftyourmind.packets.server;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.server.v1_9_R2.Packet;
/*    */ import net.minecraft.server.v1_9_R2.PacketDataSerializer;
/*    */ import net.minecraft.server.v1_9_R2.PacketListener;
/*    */ 
/*    */ public class PacketInDonjon
/*    */   implements Packet<PacketListener>
/*    */ {
/*    */   public static final String DELIMITER = "";
/*    */   public static final int WORLD = 0;
/*    */   public int action;
/*    */   public String names;
/*    */   public int playerNb;
/*    */ 
/*    */   public PacketInDonjon()
/*    */   {
/*    */   }
/*    */ 
/*    */   public PacketInDonjon(int action, String names, int playerNb)
/*    */   {
/* 23 */     this.action = action;
/* 24 */     this.names = names;
/* 25 */     this.playerNb = playerNb;
/*    */   }
/*    */ 
/*    */   public void a(PacketDataSerializer arg0) throws IOException
/*    */   {
/* 30 */     this.action = arg0.readInt();
/* 31 */     this.names = arg0.e(32767);
/* 32 */     this.playerNb = arg0.readInt();
/*    */   }
/*    */ 
/*    */   public void a(PacketListener arg0)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void b(PacketDataSerializer arg0)
/*    */     throws IOException
/*    */   {
/* 42 */     arg0.writeInt(this.action);
/* 43 */     arg0.a(this.names);
/* 44 */     arg0.writeInt(this.playerNb);
/*    */   }
/*    */   public int getDongeon() {
/* 47 */     return this.action;
/*    */   }
/*    */ 
/*    */   public String getPlayers() {
/* 51 */     return this.names;
/*    */   }
/*    */ 
/*    */   public int getPlayerNumber() {
/* 55 */     return this.playerNb;
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.packets.server.PacketInDonjon
 * JD-Core Version:    0.6.2
 */