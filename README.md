Option Explicit

Public watchingScreenshots As Boolean  ' Global flag to control the loop
Dim lastFileCount As Long
Const watchFolder As String = "C:\Users\Vivek\Pictures\Screenshots" ' <-- your folder

Sub AutoInsertScreenshots()
    On Error Resume Next

    ' If the watcher is not enabled, exit immediately (prevents work on a pending tick)
    If Not watchingScreenshots Then Exit Sub

    Dim fso As Object, folder As Object, file As Object
    Set fso = CreateObject("Scripting.FileSystemObject")
    Set folder = fso.GetFolder(watchFolder)

    ' Check if new files appeared
    If folder.Files.Count > lastFileCount Then
        For Each file In folder.Files
            ' Only pick files created in the last 5 seconds
            If file.DateCreated > Now - TimeValue("00:00:05") Then
                Selection.InlineShapes.AddPicture file.Path
                Selection.TypeParagraph
            End If
        Next
    End If

    lastFileCount = folder.Files.Count

    ' Only re-schedule if we're still running
    If watchingScreenshots Then
        Application.OnTime Now + TimeValue("00:00:03"), "AutoInsertScreenshots"
    End If
End Sub

' Optional helper to start the loop cleanly (bind this to your Start button)
Sub StartAutoInsert()
    watchingScreenshots = True
    ' Kick off the first run immediately
    AutoInsertScreenshots
End Sub
