import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Main {
	private final static ArrayList<Turma> Turmas = LoadDataTurma();
    private final static ArrayList<Disciplina> Cursos = LoadDataDisciplina();
    private final static ArrayList<Aluno> Alunos = LoadDataAlunos();
    private final static ArrayList<Professores> Professor = LoadDataProf();
    public static void main(String[] args) {
        int opc = -1;
        while (opc != 0){
        	System.out.println("Opção 0- Sair");
            System.out.println("Opção 1: Alunos");
            System.out.println("Opção 2: Professores");
            System.out.println("Opção 3: Disciplinas");
            System.out.println("Opção 4: Turmas");
            opc = Ler.umInt();
            switch (opc){
            //Opcoes Aluno
            case 1:
            	int opcAl = -1;
            	while (opcAl != 0){
                    System.out.println("Opção 0- Sair");
                    System.out.println("Opção 1- Adicionar Aluno");
                    System.out.println("Opção 2- Remover Aluno");
                    System.out.println("Opção 3- Mostrar Alunos");
                    System.out.println("Opção 4- Atualizar Aluno");
                    System.out.println("Opção 5- Média das Idades dos Alunos da escola");
                    System.out.println("Opção 6- Qual a proveniência geográfica dos alunos da escola?");
                    opcAl = Ler.umInt();
                    switch (opcAl){
                    case 1:
                    	//Adicionar Aluno
                    	System.out.println("Introduza o Nome do Aluno: ");
                        String nome = Ler.umaString();
                        System.out.println("Introduza a Localidade do Aluno: ");
                        String local = Ler.umaString();
                        System.out.println("Introduza a Data de nascimento do aluno: ");
                        System.out.println("Introduza o dia");
                        int dia = Ler.umInt();
                        System.out.println("Introduza o mês");
                        int mes = Ler.umInt();
                        System.out.println("Introduza o ano");
                        int ano = Ler.umInt();
                        LocalDate dataNasc;
                        dataNasc = LocalDate.of(ano, mes, dia);
                        System.out.println(dataNasc);
                        Alunos.add(new Aluno(Alunos.size() + 1,nome,dataNasc,local));
						SaveData(Alunos,"alunos.dat");
                       break;
                    case 2:
                    	//Apagar Aluno
                    	System.out.println("Introduza o numero do aluno que deseja apagar");
                    	int numeroApagar = Ler.umInt();
                    	for(int i = 0 ; i < Alunos.size() ; i++) {
                			if (Alunos.get(i).getId() == numeroApagar) {
                				Alunos.remove(i);
                			}
                		}
						SaveData(Alunos,"alunos.dat");
                        break;
                    case 3:
                    	//Mostrar Alunos
                		for(int i = 0 ; i < Alunos.size() ; i++) {
                			System.out.println(Alunos.get(i).toString() + "\n");
                		}
                        break;
                    case 4:
                    	//Mudar Aluno
                    	System.out.println("Introduza o Numero do Aluno que deseja atualizar: ");
                    	int idAtualizar = Ler.umInt();
                    	for(int i = 0 ; i < Alunos.size() ; i++) {
                			if (Alunos.get(i).getId() == idAtualizar) {
                				System.out.println("Introduza o novo Nome do Aluno: ");
                                String nomeAt = Ler.umaString();
                                System.out.println("Introduza a nova Localidade do Aluno: ");
                                String localAt = Ler.umaString();
                                System.out.println("Introduza a nova Data de nascimento do aluno: ");
                                System.out.println("Introduza o dia");
                                int diaAt = Ler.umInt();
                                System.out.println("Introduza o mês");
                                int mesAt = Ler.umInt();
                                System.out.println("Introduza o ano");
                                int anoAt = Ler.umInt();
                                LocalDate dataNascAt;
                                dataNascAt = LocalDate.of(anoAt, mesAt, diaAt);
                                System.out.println(dataNascAt);
                                Alunos.get(i).setNome(nomeAt);
                                Alunos.get(i).setIdade(dataNascAt);
                                Alunos.get(i).setLocalidade(localAt);
								SaveData(Alunos,"alunos.dat");
                			}
                			else {
                				System.out.println("Nao existe aluno com esse numero");
                			}
                    	}
                    	break;
                    case 5: //Média das Idades dos Alunos
                        if (Alunos.isEmpty()) {
                            System.out.println("Não existem alunos para calcular a média de idades.");
                        } else {
                            int somaIdades = 0;
                            for (Aluno aluno : Alunos) {
                                LocalDate dataNascimento = aluno.getIdade();
                                LocalDate dataAtual = LocalDate.now();
                                int idade = Period.between(dataNascimento, dataAtual).getYears();
                                somaIdades += idade;
                            }

                            double mediaIdades = (double) somaIdades / Alunos.size();
                            System.out.println("Média das Idades dos Alunos: " + mediaIdades);
                        }
                        
                        break;
                    case 6:
                        // Proveniência geográfica dos alunos
                        if (Alunos.isEmpty()) {
                            System.out.println("Não existem alunos inscritos.");
                        } else {
                            System.out.println("Proveniência Geográfica dos Alunos:");
                            for (Aluno aluno : Alunos) {
                                System.out.println(aluno.getNome() + ": " + aluno.getLocalidade());
                            }
                        }
                        break;
                    }
            	}
             break;
             //Opcoes Profs
             case 2: 
            		int opcProf = -1;
                	while (opcProf != 0){
                        System.out.println("Opção 0- Sair");
                        System.out.println("Opção 1- Adicionar Professor");
                        System.out.println("Opção 2- Remover Professor");
                        System.out.println("Opção 3- Mostrar Professores");
                        System.out.println("Opção 4- Atualizar Professor");
                        opcProf = Ler.umInt();
                        switch (opcProf){
                        case 1:
                        	//Adicionar Prof
                        	System.out.println("Introduza o Nome do Professor: ");
                            String nome = Ler.umaString();
                            System.out.println("Introduza a Localidade do Professor: ");
                            String local = Ler.umaString();
                            System.out.println("Introduza a Data de nascimento do Professor: ");
                            System.out.println("Introduza o dia");
                            int dia = Ler.umInt();
                            System.out.println("Introduza o mês");
                            int mes = Ler.umInt();
                            System.out.println("Introduza o ano");
                            int ano = Ler.umInt();
                            LocalDate dataNasc;
                            dataNasc = LocalDate.of(ano, mes, dia);
                            System.out.println(dataNasc);
                            Professor.add(new Professores(Professor.size() + 1,nome,dataNasc,local));
							SaveData(Professor,"prof.dat");
                           break;
                        case 2:
                        	//Apagar Professor
                        	System.out.println("Introduza o numero do Professor que deseja apagar");
                        	int numeroApagar = Ler.umInt();
                        	int i = 0; 
                        	for(i = 0 ; i < Professor.size() ; i++) {
                    			if (Professor.get(i).getId() == numeroApagar) {
                    				Professor.remove(i);
                    			}
                    			else {
                    				System.out.println("Nao existe professor com esse numero");
                    			}
                    		}
							SaveData(Professor,"prof.dat");
                           break;
                        case 3:
                        	//Mostrar Professores
                    		for(i = 0 ; i < Professor.size() ; i++) {
                    			System.out.println(Professor.get(i).toString() + "\n");
                    		}
                           break;
                        case 4: 
                        	//Mudar Professor
                        	System.out.println("Introduza o Numero do Professor que deseja atualizar: ");
                        	int idAtualizar = Ler.umInt();
                        	for(i = 0 ; i < Professor.size() ; i++) {
                    			if (Professor.get(i).getId() == idAtualizar) {
                    				System.out.println("Introduza o novo Nome do Professor: ");
                                    String nomeAt = Ler.umaString();
                                    System.out.println("Introduza a nova Localidade do Professor: ");
                                    String localAt = Ler.umaString();
                                    System.out.println("Introduza a nova Data de nascimento do Professor: ");
                                    System.out.println("Introduza o dia");
                                    int diaAt = Ler.umInt();
                                    System.out.println("Introduza o mês");
                                    int mesAt = Ler.umInt();
                                    System.out.println("Introduza o ano");
                                    int anoAt = Ler.umInt();
                                    LocalDate dataNascAt;
                                    dataNascAt = LocalDate.of(anoAt, mesAt, diaAt);
                                    System.out.println(dataNascAt);
                                    Professor.get(i).setNome(nomeAt);
                                    Professor.get(i).setIdade(dataNascAt);
                                    Professor.get(i).setLocalidade(localAt);
									SaveData(Professor,"prof.dat");
                    			}
                    			else {
                    				System.out.println("Nao existe professor com esse numero");
                    			}
                        	}
                            break;		
                        }
                     }
             break;
             //Opcoes Disciplina
             case 3:
            	 int opcDis = -1;
             	while (opcDis != 0){
                     System.out.println("Opção 0- Sair");
                     System.out.println("Opção 1 - Adicionar Disciplina");
                     System.out.println("Opção 2 - Remover Disciplina");
                     System.out.println("Opção 3 - Mostrar Disciplina");
                     System.out.println("Opção 4 - Mudar Nome Disciplina");
                     System.out.println("Opção 5 - Adicionar aula a disciplina");
                     System.out.println("Opção 6 - Remover aula a disciplina");
                     opcDis = Ler.umInt();
                     switch (opcDis){
                     //Adicionar Disciplina
                     case 1:
                     System.out.println("Introduza o Nome da Disciplina ");
                     String nomeDiscp = Ler.umaString();
                	 int HcN = 0;
                	 int McN = 0;
                	 int HfN = 0;
                	 int MfN = 0;
                	 String diaAulaN = "";
                     System.out.println("Introduza o dia da Semana da Aula");
       					diaAulaN = Ler.umaString();
       				do {
       				System.out.println("Introduza a Hora de Começo");
       				HcN = Ler.umInt();
       				}while(HcN < 1 || HcN > 23);
       				do {
       				System.out.println("Introduza o Minuto de Começo");
       				McN = Ler.umInt();
       				}while(McN < 1 || McN > 59);
       				do {
       				System.out.println("Introduza a Hora em que acaba");
       				HfN = Ler.umInt();
       				}while(HfN < 1 || HfN > 23 || HfN < HcN);
       				do {
       				System.out.println("Introduza o Minuto em que acaba");
       				MfN = Ler.umInt();
       				}while(HcN < 1 || MfN > 59);
                     Cursos.add(new Disciplina(Cursos.size() + 1 ,  nomeDiscp, new HoraSemana(diaAulaN, HcN , McN, HfN , MfN)));
					 SaveData(Cursos,"disciplina.dat");
                     break;
                     case 2 :
                     //Remover Disciplina
                     System.out.println("Introduza o ID da Disciplina ");
                     int id = Ler.umInt();
                     int i = 0;
                     for(i = 0 ; i < Cursos.size() ; i++) {
             			if (Cursos.get(i).getId() == id) {
             				Cursos.remove(i);
             			}
             			else {
             				System.out.println("Não existe uma disciplina com esse ID ");
             				}
             			}
					 SaveData(Cursos,"disciplina.dat");
                     break;
                     case 3:
                     //Mostrar Disciplinas
                    	 for(i = 0 ; i < Cursos.size() ; i++) {
                    		 System.out.println(Cursos.get(i).toString());
                  			}
                     break;
                     case 4:
                   	 //Mudar Nome Disciplina
                     System.out.println("Introduza o Id da Disciplina que pretende alterar");
                     int idAlt = Ler.umInt();
                     for(i = 0 ; i < Cursos.size() ; i++) {
                    	 if(idAlt ==  Cursos.get(i).getId()) {
                    		 System.out.println("Introduza o novo Nome da Disciplina ");
                             String NovoNomeDiscp = Ler.umaString();
                             Cursos.get(i).setNomeDiscp(NovoNomeDiscp);
                    	 }
                    	 else {
                    		 System.out.println("Não existe disciplina com esse ID");
                    	 }
                     }
					 SaveData(Cursos,"disciplina.dat");
                     break;
                     case 5:
                     //Adicionar Hora de Aulas
                    	 System.out.println("Introduza o Id da Disciplina a que pretende adicionar uma Aula ");
                    	 int idA = Ler.umInt();
                    	 int Hc = 0;
                    	 int Mc = 0;
                    	 int Hf = 0;
                    	 int Mf = 0;
                    	 String diaAula = "";
                    	 for(i = 0 ; i < Cursos.size() ; i++) {
                  			if (Cursos.get(i).getId() == idA) {
                  				System.out.println("Introduza o dia da Semana da Aula");
                  				diaAula = Ler.umaString();
                  				do {
                  				System.out.println("Introduza a Hora de Começo");
                  				Hc = Ler.umInt();
                  				}while(Hc < 1 || Hc > 23);
                  				do {
                  				System.out.println("Introduza o Minuto de Começo");
                  				Mc = Ler.umInt();
                  				}while(Mc < 1 || Mc > 59);
                  				do {
                  				System.out.println("Introduza a Hora em que acaba");
                  				Hf = Ler.umInt();
                  				}while(Hf < 1 || Hf > 23 || Hf < Hc);
                  				do {
                  				System.out.println("Introduza o Minuto em que acaba");
                  				Mf = Ler.umInt();
                  				}while(Hc < 1 || Mf > 59);	 
                  			Cursos.get(i).getHoraAulas().add(new HoraSemana(diaAula, Hc , Mc , Hf , Mf));
                  			}
                  			else {
                  				System.out.println("Não existe uma disciplina com esse ID ");
                  				}                   	 
                    	 	}
                    break;
                    case 6:
                    //Remover Hora de Aulas
                    	 System.out.println("Introduza o Id da Disciplina de que pretende remover uma Aula ");
                    	 int idR = Ler.umInt();
                    	 int HcR = 0;
                    	 int McR = 0;
                    	 int HfR = 0;
                    	 int MfR = 0;
                    	 String diaAulaR = "";
                    	 for(i = 0 ; i < Cursos.size() ; i++) {
                  			if (Cursos.get(i).getId() == idR) {
                  				System.out.println("Introduza o dia da Semana da Aula");
                  				diaAula = Ler.umaString();
                  				do {
                  				System.out.println("Introduza a Hora de Começo");
                  				Hc = Ler.umInt();
                  				}while(HcR < 1 || HcR > 23);
                  				do {
                  				System.out.println("Introduza o Minuto de Começo");
                  				Mc = Ler.umInt();
                  				}while(McR < 1 || McR > 59);
                  				do {
                  				System.out.println("Introduza a Hora em que acaba");
                  				Hf = Ler.umInt();
                  				}while(HfR < 1 || HfR > 23 || HfR < HcR);
                  				do {
                  				System.out.println("Introduza o Minuto em que acaba");
                  				Mf = Ler.umInt();
                  				}while(HcR < 1 || MfR > 59);	
                  				int k = 0;
                  				for ( k = 0; k < Cursos.get(i).getHoraAulas().size(); k++) {
                  					if(Cursos.get(i).getHoraAulas().get(k).equals(new HoraSemana(diaAulaR, HcR , McR , HfR , MfR))){
                  						Cursos.get(i).getHoraAulas().remove(k);
                  					}
                  					else {
                  						System.out.println("Não existe uma disciplina com uma Aula na hora especificada ");
                  					}
                  				}                  					                  				
                  			}else {
                  				System.out.println("Não existe uma disciplina com esse ID ");
                  				}  
                  			}         
             		}
             	}
             break;
             case 4:
            	int opcTurma = -1;
              	while (opcTurma != 0){
                      System.out.println("Opção 0- Sair");
                      System.out.println("Opção 1 - Adicionar Turma");
                      System.out.println("Opção 2 - Remover Turma");
                      System.out.println("Opção 3 - Mostrar Turma");
                      System.out.println("Opção 4 - Adicionar aluno à turma");
                      System.out.println("Opção 5 - Remover aluno da turma");
                      System.out.println("Opção 6 - Adicionar disciplina à turma");
                      System.out.println("Opção 7 - Remover disciplina da turma");
                      System.out.println("Opção 8 - Adicionar Professor à turma");
                      System.out.println("Opção 9 - Remover Professor da turma");
                      System.out.println("Opção 10 - Turma com mais inscritos");
                      System.out.println("Opção 11 - Média das idades dos alunos de uma turma");
                      opcTurma = Ler.umInt();
                      switch (opcTurma) {
                      case 1:
                    	  //Criar turma (sem prof alunos ou disciplinas)
                    	  Turmas.add(new Turma(Turmas.size() + 1, new  ArrayList<Aluno> (), new  ArrayList<Disciplina> (), new  ArrayList<Professores> ()));
                    	  System.out.println("Foi criada uma turma com o numero " + Turmas.size());
						  SaveData(Turmas,"turma.dat");
                      break;
                      case 2:
                    	  //Remover Turma
                    	  int i = 0;
                    	  System.out.println("Insira o numero da turma que pretende apagar");
                    	  int numeroT = Ler.umInt();
                    	  for(i = 0; i < Turmas.size(); i++) {
                    		  if ( Turmas.get(i).getNumeroTurma() == numeroT) {
                    			  Turmas.remove(i);
                    		  }else {
                    			  System.out.println("Nao existe turma com esse numero");  
                    		  }
                    	  }
						  SaveData(Turmas,"turma.dat");
                      break;
                      case 3:
                    	  //Mostrar Turmas
                    	  for(i = 0 ; i < Turmas.size() ; i++) {
                     		 System.out.println(Turmas.get(i).toString());
                   			}
                      break;
                      case 4:
                    	  //Adicionar Aluno
                    	  int k = 0;
                    	  System.out.println("Insira o Id do aluno que pretende adicionar");
                    	  int alAdd = Ler.umInt();
                    	  System.out.println("Insira o numero da turma a que pretende adicionar o aluno");
                    	  int turmaAdd = Ler.umInt();
                    	  for(i = 0 ; i < Alunos.size() ; i++) {
                    		  if( alAdd == Alunos.get(i).getId()) {
                    			  for(k = 0 ; k < Turmas.size() ; k++) {
                    				  if(turmaAdd == Turmas.get(k).getNumeroTurma()) {
                    					  Turmas.get(k).getAlunos().add(Alunos.get(i));
                    				  }else {
                    					  System.out.println("Não existe uma turma com o numero especificado");
                    				  }
                    			  }
                    		  }else {
                    			  System.out.println("Não existe um aluno com esse Id");
                    		  }
                    	  }
						  SaveData(Turmas,"turma.dat");
                      break;
                      case 5:
                    	 //Remover Aluno
                    	  System.out.println("Insira o Id do aluno que pretende remover");
                    	  int alRem = Ler.umInt();
                    	  System.out.println("Insira o numero da turma de que pretende remover o aluno");
                    	  int turmaRem = Ler.umInt();
                    	  for(i = 0 ; i < Alunos.size() ; i++) {
                    		  if( alRem == Alunos.get(i).getId()) {
                    			  for(k = 0 ; k < Turmas.size() ; k++) {
                    				  if(turmaRem == Turmas.get(k).getNumeroTurma()) {
                    					  Turmas.get(k).getAlunos().remove(Alunos.get(i));
                    				  }else {
                    					  System.out.println("Não existe uma turma com o numero especificado");
                    				  }
                    			  }
                    		  }else {
                    			  System.out.println("Não existe um aluno com esse Id");
                    		  }
                    	  }
						  SaveData(Turmas,"turma.dat");
                       break; 
                      case 6:
                    	  //Adicionar Disciplina
                    	  System.out.println("Insira o Id da Disciplina que pretende adicionar");
                    	  int discpAdd = Ler.umInt();
                    	  System.out.println("Insira o numero da turma a que pretende adicionar o aluno");
                    	  int turmaAddD = Ler.umInt();
                    	  for(i = 0 ; i < Cursos.size() ; i++) {
                    		  if( discpAdd == Cursos.get(i).getId()) {
                    			  for(k = 0 ; k < Turmas.size() ; k++) {
                    				  if(turmaAddD == Turmas.get(k).getNumeroTurma()) {
                    					  Turmas.get(k).getDisciplinas().add(Cursos.get(i));
                    					  Turmas.get(k).getHorario().addAll(Cursos.get(i).getHoraAulas());
                    				  }else {
                    					  System.out.println("Não existe uma turma com o numero dado");
                    				  }
                    			  }
                    		  }else {
                    			  System.out.println("Não existe uma disciplina com esse Id");
                    		  }
                    	  	}
						  SaveData(Turmas,"turma.dat");
                     break;
                     case 7:
                    	 //Remover Disciplina
                    	 System.out.println("Insira o Id da Disciplina que pretende remover");
                   	  int discpRem = Ler.umInt();
                   	  System.out.println("Insira o numero da turma de que pretende a disciplina");
                   	  int turmaRemD = Ler.umInt();
                   	  for(i = 0 ; i < Cursos.size() ; i++) {
                   		  if( discpRem == Cursos.get(i).getId()) {
                   			  for(k = 0 ; k < Turmas.size() ; k++) {
                   				  if(turmaRemD == Turmas.get(k).getNumeroTurma()) {
                   					  Turmas.get(k).getDisciplinas().remove(Cursos.get(i));
                   					  Turmas.get(k).getHorario().removeAll(Cursos.get(i).getHoraAulas());
                   				  }else {
                   					  System.out.println("Não existe uma turma com o numero dado");
                   				  }
                   			  }
                   		  }else {
                   			  System.out.println("Não existe uma disciplina com esse Id");
                   		  }
                   	  	}
						 SaveData(Turmas,"turma.dat");
                   	 break;
                     case 8:
                    	 System.out.println("Insira o Id do Professor que pretende adicionar");
                   	  int profAdd = Ler.umInt();
                   	  System.out.println("Insira o numero da turma a que pretende adicionar o Professor");
                   	  int turmaAddP = Ler.umInt();
                   	  for(i = 0 ; i < Professor.size() ; i++) {
                   		  if( profAdd == Professor.get(i).getId()) {
                   			  for(k = 0 ; k < Turmas.size() ; k++) {
                   				  if(turmaAddP == Turmas.get(k).getNumeroTurma()) {
                   					  Turmas.get(k).getProfessores().add(Professor.get(i));
                   				  }else {
                   					  System.out.println("Não existe uma turma com o numero especificado");
                   				  }
                   			  }
                   		  }else {
                   			  System.out.println("Não existe um Professor com esse Id");
                   		  }
                   	  }
                     break;
                     case 9:
                    	 System.out.println("Insira o Id do Professor que pretende remover");
                      	  int profRem = Ler.umInt();
                      	  System.out.println("Insira o numero da turma de que pretende remover o Professor");
                      	  int turmaRemP = Ler.umInt();
                      	  for(i = 0 ; i < Professor.size() ; i++) {
                      		  if( profRem == Professor.get(i).getId()) {
                      			  for(k = 0 ; k < Turmas.size() ; k++) {
                      				  if(turmaRemP == Turmas.get(k).getNumeroTurma()) {
                      					  Turmas.get(k).getProfessores().remove(Professor.get(i));
                      				  }else {
                      					  System.out.println("Não existe uma turma com o numero especificado");
                      				  }
                      			  }
                      		  }else {
                      			  System.out.println("Não existe um Professor com esse Id");
                      		  }
                      	  } 
                     break;
                     case 10:
                    	 // Turma com mais inscritos
                    	    Turma turmaComMaisInscritos = null;
                    	    int maxInscritos = 0;

                    	    for (Turma turma : Turmas) {
                    	        int numInscritos = turma.getAlunos().size();
                    	        if (numInscritos > maxInscritos) {
                    	            maxInscritos = numInscritos;
                    	            turmaComMaisInscritos = turma;
                    	        }
                    	    }

                    	    if (turmaComMaisInscritos != null) {
                    	        System.out.println("Turma com mais inscritos: Turma " + turmaComMaisInscritos.getNumeroTurma());
                    	        System.out.println("Número de inscritos: " + maxInscritos);
                    	        System.out.println("Alunos na turma:");
                    	        for (Aluno aluno : turmaComMaisInscritos.getAlunos()) {
                    	            System.out.println(aluno.toString());
                    	        }
                    	    } else {
                    	        System.out.println("Não há inscritos em nehuma turma.");
                    	    }
                    	 break;
                     case 11:
                         // Média das idades dos alunos de uma turma
                         System.out.println("Insira o número da turma para calcular a média das idades:");
                         int numeroTurmaMediaIdades = Ler.umInt();
                         Turma turmaSelecionada = null;

                         // Procurar a turma com o número especificado
                         for (Turma t : Turmas) {
                             if (t.getNumeroTurma() == numeroTurmaMediaIdades) {
                                 turmaSelecionada = t;
                                 break;
                             }
                         }

                         if (turmaSelecionada != null && !turmaSelecionada.getAlunos().isEmpty()) {
                             int somaIdades = 0;

                             // Calcular a soma das idades dos alunos da turma
                             for (Aluno aluno : turmaSelecionada.getAlunos()) {
                                 LocalDate dataNascimento = aluno.getIdade();
                                 LocalDate dataAtual = LocalDate.now();
                                 int idade = Period.between(dataNascimento, dataAtual).getYears();
                                 somaIdades += idade;
                             }

                             double mediaIdadesTurma = (double) somaIdades / turmaSelecionada.getAlunos().size();
                             System.out.println("Média das Idades dos Alunos da Turma " + turmaSelecionada.getNumeroTurma() + ": " + mediaIdadesTurma);
                         } else {
                             System.out.println("Turma não encontrada ou não há alunos na turma.");
                         }
                         break;
                 }
             }
          break;
        }
       }
    }

	public static ArrayList<Aluno> LoadDataAlunos(){
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("alunos.dat"));
			ArrayList<Aluno> save = (ArrayList<Aluno>) is.readObject();
			is.close();
			return save;
		}   catch (Exception e){
			System.out.println(e.getMessage());
			return new ArrayList<Aluno>();
		}
	}

	public static void SaveData(Object obj, String FileName){
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FileName));
			os.writeObject(obj);
			os.close();
		}   catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Disciplina> LoadDataDisciplina(){
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("disciplina.dat"));
			ArrayList<Disciplina> save = (ArrayList<Disciplina>) is.readObject();
			is.close();
			return save;
		}   catch (Exception e){
			System.out.println(e.getMessage());
			return new ArrayList<Disciplina>();
		}
	}

	public static ArrayList<Turma> LoadDataTurma(){
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("turma.dat"));
			ArrayList<Turma> save = (ArrayList<Turma>) is.readObject();
			is.close();
			return save;
		}   catch (Exception e){
			System.out.println(e.getMessage());
			return new ArrayList<Turma>();
		}
	}

	public static ArrayList<Professores> LoadDataProf(){
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("prof.dat"));
			ArrayList<Professores> save = (ArrayList<Professores>) is.readObject();
			is.close();
			return save;
		}   catch (Exception e){
			System.out.println(e.getMessage());
			return new ArrayList<Professores>();
		}
	}
}